package 多线程;

//线程同步

/*写在前面:
线程：A、B；
线程内容：x（初始值100）反复减去y（本例中值为30不变）三次，并返回结果；
线程同步后的输出结果：70、40、10、-20、-50、-80；
线程不同步的输出结果：40、40、-20、-20、-80、-80；
*/

public class eightPlus{
	static class Bank
	{
		private int x=100;
		public int getX()
		{
			return x;
		}
		public int fix(int y)
		{
			synchronized(this)
				//联合语句
			{
			x=x-y;
			System.out.println(Thread.currentThread().getName()+":当前bank对象的x值="+getX());
				//如果将结果输出放在这里则结果正常，反之错误；
			}
			return x;
		}
	}
	
	static public class emm implements Runnable
	{
		private Bank bank=new Bank();
		public static void main(String args[])
		{
			emm r=new emm();
			Thread ta=new Thread(r,"Thread-A");
			Thread tb=new Thread(r,"Thread-B");
			ta.start();
			tb.start();
		}
		public void run()
		{
			for(int i=0;i<3;i++)
			{
			this.fix(30);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			}
		}
			
			public int fix(int y)
			{
				{
					return bank.fix(y);
				}
			}
		
	}
}
