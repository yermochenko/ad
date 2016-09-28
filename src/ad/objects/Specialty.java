package ad.objects;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Specialty {
	private Integer Id;
	private String Code;
	private String Name;
	private String ShortName;
	private String Qualification;
	private String SpecialtyDirection;
	private Specialty Parent;
	private Map <Integer, Specialty> Children;
	
	public Integer getId(){
		return Id;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
	
	public String getCode(){
		return Code;
	}
	public void setCode(String Code){
		this.Code=Code;
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
	
	public String getQualification(){
		return Qualification;
	}
	public void setQualification(String Qualification){
		this.Qualification=Qualification;
	}
	
	public String getSpecialtyDirection(){
		return SpecialtyDirection;
	}
	public void setSpecialtyDirection(String SpecialtyDirection){
		this.SpecialtyDirection=SpecialtyDirection;
	}
	
	public Specialty getParent(){
		return Parent;
	}
	public void setParent(Specialty Parent){
		this.Parent=Parent;
	}
	
	public void initialize(){
		if(Children!=null){
			Children=new HashMap<>();
		}
	}
	public Collection <Specialty> getAllChildren(){
		return Children.values();
	}
	public void addChild(Specialty Child){
		Children.put(Child.getId(), Child);
	}
	public void deleteChildById(Integer Id){
		Children.remove(Id);
	}
}