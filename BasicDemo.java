package p1;

import java.time.LocalTime;



interface Connectable {
	public void doConnection();
}

/* before Lambda*/
class MobilePhone implements Connectable {
	@Override
	public void doConnection() {
		System.out.println(" Device get Connected...");
	}
}

/* Using Annymous Inner Class*/
class Watch
{
	public LocalTime getTime()
	{
		return LocalTime.now();
	}
	
	public void getFaceBookNotifications()
	{
		Connectable mywatch = new Connectable() {
			
			@Override
			public void doConnection() {
				// TODO Auto-generated method stub
				System.out.println(" --- Code to Connect the device");
				System.out.println(" -- Facebook login---");
				System.out.println(" --- get FB Notifications...");
			}
		};
		mywatch.doConnection();
	}
}

/* Using Lambda expression*/ 
class BluetoohSpeeker
{
	
	public void playMP3() {
		System.out.println(" ---Start play mp3...");
	}
	
	public void setConnection()
	{
		Connectable device = ()->{
			// TODO Auto-generated method stub
			System.out.println(" --- Code to Connect the device");
			System.out.println(" -- Bluetooth Connected---");
			playMP3();
		};
		device.doConnection();
	}

}

public class BasicDemo {
	public static void main(String[] args) {
		BasicDemo exe = new BasicDemo();
		//exe.approach1();
		//exe.approach2();
		exe.approach3();
		
	}

	// Approach 1
	public void approach1() {
		MobilePhone device = new MobilePhone();
		device.doConnection();
	}

	// Approach 2
	// approach 2 does not rely on class MobilePhone
	public void approach2() {
		Connectable device = new Connectable() {
			
			@Override
			public void doConnection() {
				System.out.println(" device get Connected after turning on the wifi");
				
			}
		};
		device.doConnection();
		
		new Watch().getFaceBookNotifications();
	}
	
	
	// approach3 through lambda
	public void approach3()
	{
		BluetoohSpeeker jbl = new BluetoohSpeeker();
		jbl.setConnection();
		
	}

}
