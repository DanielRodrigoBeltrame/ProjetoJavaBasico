package services;

public class StudantService {
 
	private int code;
    private String name;
    private float value;
	
    public StudantService(int code, String name, float value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }
    
    
    public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
}
