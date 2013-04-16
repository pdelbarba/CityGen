import java.util.Random;

public class SceneGen {
	
	final int ROADFREQ = 5;
	Random rand;
	GridSquare[][] gs;
	int sx;
	int sy;

	public SceneGen(int sx, int sy) {
		rand = new Random();
		gs = new GridSquare[sx][sy];
		this.sx = sx;
		this.sy = sy;
	}

	public void gen() {
		for(int y = 0; y < sy; y++) {
			if(	//make sure the previous 2 rows are not roads
				y > 1 && 
				gs[0][y - 1] == GridSquare.ROAD_H && 
				rand.nextInt(ROADFREQ) == 0) {
				//fill row with "roadH"
				for(int x = 0; x < sx; x++) {
					gs[x][y] = new GridSquare();
					gs[x][y] = GridSquare.ROAD_H;
				}
			}
		}
		//do the same for the vertical roads
		for(int x = 0; x < sx; x++) {
			if(	//make sure the previous 2 rows are not roads
				x > 1 && 
				gs[0][y - 1] == GridSquare.ROAD_V && 
				rand.nextInt(ROADFREQ) == 0) {
				//fill row with vertical road blocks
				for(int y = 0; y < sy; y++) {
					if(gs[x][y] != null) {
						gs[x][y] = GridSquare.INTERSECTION;
					} else {
						gs[x][y] = new GridSquare();
						gs[x][y] = GridSquare.ROAD_V;
					}
				}
			}
		}
	}
}