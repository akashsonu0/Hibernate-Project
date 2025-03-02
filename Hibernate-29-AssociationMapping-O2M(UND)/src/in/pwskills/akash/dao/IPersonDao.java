package in.pwskills.akash.dao;

public interface IPersonDao {
	//performing insert operation using parent
	public void saveRecordUsingParent();
	
	public void addChildToExistingParent();
	
	//performing select operation using parent
	public void loadRecordUsingParent();
	
	//delete operations using parent
	public void deleteAllChildsOfAParent();
	public void deleteOneChildFromCollectionofChildsOfAParent();
	public void deleteParentAndItsChilds();
}
