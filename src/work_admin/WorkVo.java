package work_admin;

public class WorkVo {

	// 필드
	private int work_id;
	private String user_id;
	private String state;
	private String work_date;
	
	// 생성자
	public WorkVo() {
		super();
	}

	public WorkVo(int work_id, String user_id, String state, String work_date) {
		super();
		this.work_id = work_id;
		this.user_id = user_id;
		this.state = state;
		this.work_date = work_date;
	}
	
	// 메소드 - getter/setter
	public int getWork_id() {
		return work_id;
	}

	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWork_date() {
		return work_date;
	}

	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}

	// 메소드 - 일반
	@Override
	public String toString() {
		return "WorkVo [work_id=" + work_id + ", user_id=" + user_id + ", state=" + state + ", work_date=" + work_date
				+ "]";
	}
	
	
	
	
}
