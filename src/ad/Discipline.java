package ad;

public class Discipline {
	private Integer Id;
	private String Name;
	private String ShortName;
	
	public Integer getId(){
		return Id;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
	
	public String getName(){
		return Name;
	}
	public void setName(String Name){
		this.Name=Name;
	}
	
	public String getShortName(){
		return ShortName;
	}
	public void setShortName(String ShortName){
		this.ShortName=ShortName;
	}
}