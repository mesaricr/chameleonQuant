/**
 * 
 */
package data.source.external.web.connector;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import data.source.external.financialdatavendors.alphavantage.AlphaVantageConnector;
import data.source.external.financialdatavendors.alphavantage.parameters.currencies.FromCurrency;
import data.source.external.financialdatavendors.alphavantage.parameters.currencies.ToCurrency;
import data.source.external.financialdatavendors.alphavantage.parameters.functions.Function;
import data.source.external.financialdatavendors.alphavantage.parameters.intradaytimeseries.Interval;
import data.source.external.financialdatavendors.alphavantage.parameters.intradaytimeseries.Slice;
import data.source.external.financialdatavendors.alphavantage.parameters.output.OutputSize;
import data.source.external.financialdatavendors.alphavantage.parameters.output.OutputType;
import data.source.external.financialdatavendors.alphavantage.parameters.symbols.Symbol;
import data.source.utils.IO.TxtUtils;

/**
 * @author stefanopenazzi
 *
 */
class TestAlphaVantageConnector {

	@Test
	void testStock() {
		AlphaVantageConnector avc = new AlphaVantageConnector(10000);
		String test = avc.call(Function.TIME_SERIES_INTRADAY_EXTENDED,new Symbol("IBM"),Interval.ONE_MIN,Slice.YEAR1MONTH1,OutputSize.FULL,OutputType.CSV);
		try {
			TxtUtils.stringToFile(test,System.getProperty("user.dir")+"/output/IBM_"+Function.TIME_SERIES_INTRADAY_EXTENDED+"_"+Interval.ONE_MIN+"_"+Slice.YEAR1MONTH1+"_"+OutputSize.FULL+"_"+OutputType.JSON+".csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testForex() {
		AlphaVantageConnector avc = new AlphaVantageConnector(10000);
		String test = avc.call(Function.FX_DAILY,new FromCurrency("EUR"),new ToCurrency("USD"), OutputSize.FULL,OutputType.CSV);
		try {
			TxtUtils.stringToFile(test,System.getProperty("user.dir")+"/output/"+new FromCurrency("EUR").getValue() +"-"+new ToCurrency("USD").getValue() +"_"+Function.FX_DAILY+"_"+OutputSize.FULL+"_"+OutputType.CSV+".csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
