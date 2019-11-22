package hashtablesbootcamp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DesignOfHashableClass {

	public static void main(String[] args) {
	}

	public static List<ContactList> mergeContactLists(List<ContactList> contactLists) {

		return new ArrayList<>(new HashSet<>(contactLists));
	}

}

// time complexity for computing the Hash is O(N), N is the number Strings in the contact list
class ContactList {
	List<String> names;

	public ContactList(List<String> names) {
		this.names = names;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof ContactList)) {
			return false;
		}
		return this == obj ? true : new HashSet<>(names).equals(new HashSet<>(((ContactList) obj).names));
	}

	@Override
	public int hashCode() {
		return new HashSet<>(names).hashCode();
	}

}