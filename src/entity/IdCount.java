package entity;

import java.util.ArrayList;
import java.util.List;

public class IdCount {
	
	private List<Integer> ids = new ArrayList<>();

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	public Integer createId() {
		Integer id = null;
		if(ids.isEmpty()) {
			id = 1;
		}else {
			id = ids.get(ids.size() - 1) + 1;
		}
		ids.add(id);
		return id;
	}
}
