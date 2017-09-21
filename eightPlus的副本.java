package 多线程;

//线程同步

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
			{
			x=x-y;
			System.out.println(Thread.currentThread().getName()+":当前bank对象的x值="+getX());
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
