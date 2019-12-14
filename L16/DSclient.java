package L16;

import L15.Stack;

class DYanamic_stack extends Stack {
	@Override
	public void push(int n) throws Exception {
		if (isFull()) {

			int[] na = new int[2 * this.data.length];
			for (int i = 0; i <= this.tos; i++) {
				na[i] = this.data[i];
			}
			this.data = na;
		}
		super.push(n);
	}

}

public class DSclient {
	public static void main(String[] args) throws Exception {

		DYanamic_stack Ds = new DYanamic_stack();
		DYanamic_stack D = new DYanamic_stack();
		Ds.push(10);
		Ds.push(20);
		Ds.push(30);
		Ds.push(40);

//		Display_Reverse(Ds);
		Actual_Reverse(Ds, D);
		Ds.display();

	}

	public static void Display_Reverse(DYanamic_stack Ds) throws Exception {
		if (Ds.isEmpty()) {
			return;
		}
		int n = Ds.pop();
		Display_Reverse(Ds);
		System.out.println(n);
		Ds.push(n);

	}

	public static void Actual_Reverse(DYanamic_stack Ds, DYanamic_stack D) throws Exception {
		if (Ds.isEmpty()) {
			if(D.isEmpty()) {
				return;
			}
			int n = D.pop();
			Actual_Reverse(Ds, D);
			Ds.push(n);

			return;

		}
		int n = Ds.pop();
		D.push(n);
		Actual_Reverse(Ds, D);
		

	}
}
