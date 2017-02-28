package ad.domain.bean;

import java.util.ArrayList;

import ad.domain.Specialty;

/*
* Специальность
* String specialtyDirection - направление специальности
* SpecialtyImpl parent - родительская специальность
* List <SpecialtyImpl> children - список дочерних
* */
public class SpecialtyImpl implements Specialty {
	private Integer id;
	private String code;
	private String name;
	private String shortName;
	private String qualification;
	private String specialtyDirection;
	private Specialty parent = null;
	private ArrayList<Specialty> children;

	public SpecialtyImpl(){
		id=-1;
		code = "";
		name = "noname";
		shortName = "";
		qualification = "";
		specialtyDirection = "";
		//parent = new SpecialtyImpl();
		children = new ArrayList<>();
	}
	public SpecialtyImpl(String code, String name, String shortname, String qualification, String specialtyDirection, Specialty parent){
		this.code = code;
		this.name = name;
		this.shortName = shortname;
		this.qualification = qualification;
		this.specialtyDirection = specialtyDirection;
		this.parent = parent;
		children = new ArrayList<>();
	}

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

	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	public ArrayList<Specialty> getChildren() {
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
	public void deleteChild(Specialty specialty){
		children.remove(specialty);
	}

	@Override
	public String toString() {
		return name;
	}
}