package ad.objects;

import java.util.List;

public class Specialty {
	private Integer id;
	private String code;
	private String name;
	private String shortname;
	private String qualification;
	private String specialtyDirection;
	private Specialty parent;
	private List <Specialty> children;
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	
	public String getCode(){
		return code;
	}
	public void setCode(String code){
		this.code=code;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public String getShortName(){
		return shortname;
	}
	public void setShortName(String shortname){
		this.shortname=shortname;
	}
	
	public String getQualification(){
		return qualification;
	}
	public void setQualification(String qualification){
		this.qualification=qualification;
	}
	
	public String getSpecialtyDirection(){
		return specialtyDirection;
	}
	public void setSpecialtyDirection(String specialtyDirection){
		this.specialtyDirection=specialtyDirection;
	}
	
	public Specialty getParent(){
		return parent;
	}
	public void setParent(Specialty parent){
		this.parent=parent;
	}
	
	public List <Specialty> getAllChildren(){
		return children;
	}
	public void addChild(Specialty child){
		children.add(child);
	}
	public void deleteChildById(Integer id){
		for(Specialty child : children){
			if(child.getId()==id){
				children.remove(child);
				break;
			}
		}
	}
}