package in.pwskills.akash.dao;

public interface IPersonDao {
	//performing insert operation using parent
	public void saveRecordUsingParent();
	
	public void saveRecordUsingChild();
	
	//performing select operation using parent
	public void loadRecordUsingParent();
	public void loadRecordUsingChild();

}
