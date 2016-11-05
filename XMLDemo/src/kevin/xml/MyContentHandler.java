package kevin.xml;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyContentHandler extends DefaultHandler{
	String hisName, address, money, sex, startus,tagName;

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("----Begin-----");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("---End----");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName = localName;
		//获取worker标签的属性
		if(localName.equals("worker")){
			for(int i=0;i<attributes.getLength();i++){
				System.out.println(attributes.getLocalName(i) + "=" +attributes.getValue(i));;
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		tagName = "";
		if(localName.equals("worker")){
			this.printout();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(tagName.equals("name")){
			hisName = new String(ch,start,length);
		}else if(tagName.equals("sex")){
			sex = new String(ch,start,length);
		}else if(tagName.equals("startus")){
			startus = new String(ch,start,length);
		}else if(tagName.equals("address")){
			address = new String(ch,start,length);
		}else if(tagName.equals("money")){
			money = new String(ch,start,length);
		}
		}
	
	private void printout(){
		System.out.print("name: ");
		System.out.println(hisName);
		System.out.print("sex: ");
		System.out.println(sex);
		System.out.print("status: ");
		System.out.println(startus);
		System.out.print("address: ");
		System.out.println(address);
		System.out.print("money: ");
		System.out.println(money);
		System.out.println();
	}
	

}
