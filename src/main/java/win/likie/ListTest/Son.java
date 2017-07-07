package win.likie.ListTest;

import java.util.*;

public class Son extends Father implements Runnable{
		private static int playTimes;
		private String name;
		private Date bothDay = new Date();
		private Integer age;


		public Son(String name, Date bothDay) {
			for (int i = 0; i < 100; i++) {//业务需要name就是name自加100次
				name += name;
			}
			this.name = name;
			this.bothDay = bothDay;
		}

		public static String getIdentifyId() {
			return "331081199104123896";
		}

		void say() {
			System.out.println("儿子说");
		}

		public Son() {

		}

		public Integer getAge() {
			if (true) {
				return 1;
			} else {
				return age;
			}
		}

		private synchronized void playGame(){
			System.out.println("start play games");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("start play end");
			playTimes++;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public static void main(String[] args) {
			Son son = new Son();
			String sonId = son.getIdentifyId();
			if (sonId.equals("331081199104123896")) {
				System.out.println(sonId);
			}
			Map testMap = new HashMap<>();
			testMap.put(son,"tom");

			List testList = new ArrayList<>();
			for(int i=0;i<5;i++){
				Son son2 = new Son();
				testList.add(son2);
			}

			testList.subList(1,3).clear();

			Son [] testArray = {new Son(),new Son(),new Son()};
			List<Son> testList3 = new ArrayList<>(Arrays.asList(testArray));// asList 返回的 list不能增加元素

			for(Object sonData : testList3){
				testList3.add(new Son());
			}

			Thread thread1 = new Thread(son);
			Thread thread2 = new Thread(son);
			Thread thread3 = new Thread(son);
			Thread thread4 = new Thread(son);
			thread1.start();
			thread2.start();
			thread3.start();
			thread4.start();
			System.out.println(son.playTimes);

		}

		@Override
		public void run() {
			playGame();
		}
	}
