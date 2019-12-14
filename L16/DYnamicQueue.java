package L16;

import L15.Queue;

class DYnamicQueue extends Queue{
	@Override
	public void enqueue(int item) throws Exception {
		if(isFull()) {
			int[] na = new int[2 * this.data.length];
			for (int i = 0; i < (this.size); i++) {
				int idx  = (this.front+i)%this.data.length;
				na[i] = this.data[idx];
				
			}
			this.data = na;
			this.front=0;
		}
		super.enqueue(item);
	}
	
	

}
