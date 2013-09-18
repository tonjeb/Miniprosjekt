
public class TableItem {



		// 0 was not defined, so we call it unknown weather
	  public static final String hmm[] = {"weather", "Sunshine", "Lightly cloudy", "Partly cloudy", "Cloudy", "Partly cloudy with light rain", 
	                                                      "Partly cloudy with thunder", "Partly cloudy with rain", "Partly cloudy with more rain", 
	                                                      "Cloudy with light rain", "Cloudy with heavy rain", "Rain and thunder", "Cloudy with rain", 
	                                                      "Clody with snow", "Thunderstorms", "Fog", "Sun with the sun below the horizon", 
	                                                      "Sun below the horizon, cloudy", "Sun below the horizon, rain", "Sun below the horizon, snow" };

	  private int itemType;
	  private static String variableName;
	  private String text;

		// Constructor receiving the type, description and time of observation
	  public TableItem (int type, String name, String txt) {
	    itemType = type;
	    variableName = name;
	    text = txt;
	  }

		// Return the 
	  public int itemType () {
	    return itemType;
	  }
	  
		// Return 
	  public static String getVariableName () {
	    return variableName;
	  }

		// Return the description of this objects weather
	  public String getText () {
	    return text;
	  }

/*		// Get the name (corresponding to the type) of this weater observation
	  public String getWeatherName () {
	    return ffffffff[itemType];
	  }
*/
		// Set the weather type for this observation (given the identifier)
	  public void itemType (int type) {
	    itemType = type;
	  }

	/*	// Set the weather type for this observation (given the name)
	  public void setWeatherType (String type) {
	    for (int i=0; i<ffff.length; i++)
	      if (type.equals (fffff)[i]) {
	        set????(i);
	        break;
	      }
	  */

		// Set the weather description
	  public void setVariableName (String name) {
	    variableName = name;
	  }

	}
	