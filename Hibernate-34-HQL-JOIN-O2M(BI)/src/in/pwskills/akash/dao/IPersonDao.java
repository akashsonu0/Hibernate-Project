package in.pwskills.akash.dao;

public interface IPersonDao {

	// performing select operation using parent
	public void loadRecordUsingJoinsParentToChild();
	public void loadRecordUsingJoinsChildToParent();

}
