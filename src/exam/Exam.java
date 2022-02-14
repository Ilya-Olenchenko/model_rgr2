package exam;

import java.util.function.BooleanSupplier;

import process.Actor;
import process.DispatcherFinishException;
import process.Store;
import rnd.Randomable;



public class Exam extends Actor {

	private Store heap;


	private double heapMaxSize;


	private double finishTime;


	private Randomable rnd;


	private BooleanSupplier heapHalfSize;


	


	protected void rule() throws DispatcherFinishException {
		

	}

		public void setFinishTime(double finishTime) {
			this.finishTime = finishTime;
		}
}
