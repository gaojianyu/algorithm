package algo;

import org.apache.commons.lang.StringUtils;
/*
 * �����뷨|˫������|ά��һ������
 */
public class BrowserBasedOnStack {
	private String currentPage;
	private StackBasedLinkedList<String> backStack;
	private StackBasedLinkedList<String> forwardStack;
	
	public BrowserBasedOnStack(){
		//�洢���������ҳ
		this.backStack=new StackBasedLinkedList<String>();
		this.forwardStack=new StackBasedLinkedList<String>();
	}
	
	//get|set
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage,String prefix) {
		this.currentPage = currentPage;
		System.out.println(prefix + " page == " + currentPage);
	}

	public StackBasedLinkedList<String> getBackStack() {
		return backStack;
	}

	public StackBasedLinkedList<String> getForwardStack() {
		return forwardStack;
	}
	
	public void setForwardStack(StackBasedLinkedList<String> forwardStack) {
		this.forwardStack = forwardStack;
	}

	//���ҳ��
	public void open(String url){
		if(StringUtils.isBlank(currentPage)){
			//�״����
			setCurrentPage(url,"open");
		}else{
			//���������¼
			getBackStack().push(getCurrentPage());
			//���ǰ����¼
//			setForwardStack(null);
			//����ҳ
			setCurrentPage(url,"open");
		}
	}
	
	//����
	public String back(){
		if(getBackStack().getTop()!=null){
			getForwardStack().push(getCurrentPage());
			String backUrl=getBackStack().pop();
			setCurrentPage(backUrl,"back");
			return backUrl;
		}else{
			System.out.println("* Cannot go back, no pages behind.");
			return null;
		}
	}
	
	//ǰ��
	public String forward(){
		if(getForwardStack().getTop()!=null){
			getBackStack().push(getCurrentPage());
			String forwardUrl=getForwardStack().pop();
			setCurrentPage(forwardUrl,"forward");
			return forwardUrl;
		}else{
			System.out.println("** Cannot go forward, no pages ahead.");
			return null;
		}
	}
	
	public static void main(String[] args) {
		BrowserBasedOnStack browser = new BrowserBasedOnStack();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.back();
        browser.back();
        browser.forward();
	}
}
