package com.emmastone.rs3.scripts.esminer.data;
public enum Rock {

	COPPER(new int[] { 11962, 11960, 11961 }, 436), 
	TIN(new int[] { 11957, 11959, 11958 }, 438), 
	IRON(new int[] { 11956, 11954, 11955 }, -1);

	private int[] rockIds;
	private int oreId;

	private Rock(int[] rockIds,int oreId) {
		this.rockIds = rockIds;
		this.oreId = oreId;
	}

	public int[] getRockIds() {
		return rockIds;
	}

	public int getOreId(){
		return oreId;
	}
}
