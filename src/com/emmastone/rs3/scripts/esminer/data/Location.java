package com.emmastone.rs3.scripts.esminer.data;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Tile;

public enum Location {

	VARROCK_EAST_MINE(new Tile[] { new Tile(3285, 3363, 0),
			new Tile(3288, 3370, 0), new Tile(3292, 3375, 0),
			new Tile(3293, 3379, 0), new Tile(3293, 3385, 0),
			new Tile(3293, 3391, 0), new Tile(3291, 3398, 0),
			new Tile(3291, 3403, 0), new Tile(3291, 3406, 0),
			new Tile(3290, 3411, 0), new Tile(3289, 3414, 0),
			new Tile(3288, 3417, 0), new Tile(3286, 3422, 0),
			new Tile(3285, 3426, 0), new Tile(3282, 3428, 0),
			new Tile(3279, 3428, 0), new Tile(3275, 3428, 0),
			new Tile(3270, 3428, 0), new Tile(3264, 3428, 0),
			new Tile(3259, 3429, 0), new Tile(3255, 3429, 0),
			new Tile(3252, 3429, 0), new Tile(3251, 3423, 0),
			new Tile(3251, 3420, 0)  },
	
			new Tile[] {new Tile(3254, 3422, 0), 
			new Tile(3254, 3424, 0), new Tile(3253, 3427, 0),
			new Tile(3256, 3429, 0), new Tile(3262, 3428, 0),
			new Tile(3268, 3428, 0), new Tile(3274, 3428, 0),
			new Tile(3279, 3428, 0), new Tile(3285, 3425, 0),
			new Tile(3285, 3418, 0), new Tile(3287, 3413, 0),
			new Tile(3291, 3407, 0), new Tile(3291, 3402, 0),
			new Tile(3292, 3396, 0), new Tile(3292, 3391, 0),
			new Tile(3291, 3387, 0), new Tile(3292, 3382, 0),
			new Tile(3292, 3378, 0), new Tile(3289, 3374, 0),
			new Tile(3287, 3371, 0), new Tile(3287, 3368, 0),
			new Tile(3284, 3364, 0) });
	
	
	private Tile[] pathToBank;
	private Tile[] pathToRock;

	private Location(Tile[] pathToBank, Tile[] pathToRock){
		
		this.pathToBank = pathToBank;
		this.pathToRock = pathToRock;
	}
	
	public Tile[] getPathToBank() {
		return pathToBank;
	}

	public Tile[] getPathToRock() {
		return pathToRock;
	}
	
	public void walkToBank(MethodContext ctx){
		ctx.movement.newTilePath(pathToBank).traverse();
	}

	public void walkToMine(MethodContext ctx){
		ctx.movement.newTilePath(pathToRock).traverse();
	}
	
}


