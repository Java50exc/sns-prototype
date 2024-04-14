package telran.aws;

import java.util.Scanner;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.*;


public class SnsPrototypeAppl {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		
		AmazonSNS client = AmazonSNSClient.builder().withRegion(Regions.US_EAST_1).build();
		
		String sensor = "test-topic";
		String topicArn = getTopicArn(args, sensor);
		String subject = getSubject(args, sensor);
		
		while(true) {
			System.out.println("Enter message");
			line = scanner.nextLine();
			client.publish(topicArn, line, subject);
		}
		

	}

	private static String getSubject(String[] args, String sensor) {
		
		return args[1] + ":" + sensor;
	}

	private static String getTopicArn(String[] args, String sensor) {
		
		return args[0] + ":" + sensor;
	}

}
