/**
 * 
 */
package com.ubs.opsit.interviews;

/**
 * @author HP
 *
 */
public class TimeConverterImpl implements TimeConverter,TimeConstants {

	/* (non-Javadoc)
	 * @see com.ubs.opsit.interviews.TimeConverter#convertTime(java.lang.String)
	 */
	
	@Override
	public String convertTime(String aTime) {
		StringBuffer finalClock = new StringBuffer();
		finalClock.append(evaluateTopRow(aTime.substring(6,aTime.length())));   finalClock.append(System.lineSeparator());
		finalClock.append(evaluateSecondRow(aTime.substring(0,2))); 			finalClock.append(System.lineSeparator());
		finalClock.append(evaluateThirdRow(aTime.substring(0,2)));				finalClock.append(System.lineSeparator());
		finalClock.append(evaluateFourthRow(aTime.substring(3,5)));				finalClock.append(System.lineSeparator());
		finalClock.append(evaluateLastRow(aTime.substring(3,5)));
//		aTime = aTime +System.lineSeparator();
		/*String finalClock = aTime;
		finalClock="Y" +System.lineSeparator();
		finalClock = finalClock +"OOOO"+System.lineSeparator();
		finalClock = finalClock +"OOOO"+System.lineSeparator();
		finalClock = finalClock +"OOOOOOOOOOO"+System.lineSeparator();
		finalClock = finalClock +"OOOO";*/
		
		return finalClock.toString();
	}
	
	private String evaluateTopRow(String secs) {
		int seconds = Integer.parseInt(secs);
		if(seconds%2==0) {
			return YELLOW;
		}
		return ORANGE;
	}

	private String evaluateSecondRow(String hours) {
		StringBuffer hrs= new StringBuffer();
		Integer HOURS = Integer.parseInt(hours);
		int x = HOURS/5;
		if(x==0) {
			hrs.append(DEFAULT_ROW);
		}else{
			while(x!=0) {
				hrs.append(RED);
				x--;
			}
		}
		hrs.append(appendOffset(hrs.toString(),DEFAULT_ROW_LENGTH));
		return hrs.toString();
	}
	
	private Object evaluateThirdRow(String hours) {
		StringBuffer hrs= new StringBuffer();
		Integer HOURS = Integer.parseInt(hours);
		int x = HOURS%5;
		if(x==0) {
			hrs.append(DEFAULT_ROW);
		}else{
			while(x!=0) {
				hrs.append(RED);
				x--;
			}
		}
		hrs.append(appendOffset(hrs.toString(),DEFAULT_ROW_LENGTH));
		return hrs.toString();
	}

	private Object evaluateFourthRow(String minutes) {
		StringBuffer mins= new StringBuffer();
		Integer MINUTES = Integer.parseInt(minutes);
		int x = MINUTES/5;
		int counter =0;
		if(x==0) {
			mins.append(DEFAULT_MINS_ROW);
		}else{
			while(x!=0) {
				counter++;
				if(counter%3==0) {//evaluate quarter of hour
					mins.append(RED);
				}else {
					mins.append(YELLOW);
				}
				x--;
			}
		}
		mins.append(appendOffset(mins.toString(),DEFAULT_MINS_ROW_LENGTH));
		return mins.toString();
	}
	
	private Object evaluateLastRow(String minutes) {
		StringBuffer mins= new StringBuffer();
		Integer MINUTES = Integer.parseInt(minutes);
		int x = MINUTES%5;
		if(x==0) {
			mins.append(DEFAULT_ROW);
		}else{
			while(x!=0) {
				mins.append(YELLOW);
				x--;
			}
		}
		mins.append(appendOffset(mins.toString(),DEFAULT_ROW_LENGTH));
		return mins.toString();
	}

	private String appendOffset(String hrs, int defaultRowLength) {
		StringBuffer offset = new StringBuffer();
		for(int i=hrs.length(); i<defaultRowLength; i++) {
			offset.append(ORANGE);
		}
		return offset.toString();
	}
}
