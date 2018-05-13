package P2P;

public class f_list {
	
	public String host;
	public String port;
	public String title;
	public String rfc;
	public int cport;
	
	public f_list(String rfc, String host, String port, String title, int cport){
		this.rfc = rfc;
		this.host = host;
		this.port = port;
		this.title = title;
		this.cport = cport;
	}

}
