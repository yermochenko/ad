package ad.objects.bean;

import ad.objects.Discipline;

/*Дисциплины*/
public class DisciplineImpl implements Discipline {
	private Integer id;
	private String name;
	private String shortname;
	
	public DisciplineImpl(){}

	public DisciplineImpl(String name, String shortname){
		this.name = name;
		this.shortname = shortname;
	}

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
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
}