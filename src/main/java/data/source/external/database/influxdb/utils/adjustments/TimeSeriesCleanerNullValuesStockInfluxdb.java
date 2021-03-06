/**
 * 
 */
package data.source.external.database.influxdb.utils.adjustments;

import java.util.ArrayList;
import java.util.List;

import data.source.external.database.influxdb.mirrors.StockEODTimeSeriesPointInfluxdb;
import data.source.internal.timeseries.cleaning.TimeSeriesCleanerI;
import data.source.internal.timeseries.point.TimeSeriesPointI;
import data.source.internal.timeseries.structure.TimeSeriesDataStructureI;


/**
 * @author stefanopenazzi
 *
 */
public class TimeSeriesCleanerNullValuesStockInfluxdb <T extends TimeSeriesPointI> implements TimeSeriesCleanerI {

	@Override
	public TimeSeriesDataStructureI clean(TimeSeriesDataStructureI tsd) {
		//List<T> rem = new ArrayList<>();
		//for(T itp: tsd) {
		//	  if(itp.getClose() == null || itp.getHigh() == null || itp.getLow() == null || itp.getOpen() == null || itp.getVolume() == null) {
		//		  rem.add(itp);
		//	  } 
		//}
		//for(T itp: rem) {
		//	tsd.removePoint(itp);
		//}
		
		return tsd;
	}

}
