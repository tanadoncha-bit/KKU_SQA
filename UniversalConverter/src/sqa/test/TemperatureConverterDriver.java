package sqa.test;

import sqa.main.TemperatureConverter;

/*
 * Bottom-up driver for TemperatureConverter.convert()
 * Stands in for UniversalConverter, which is not yet integrated at this
 * point in the bottom-up build order.
 */
public class TemperatureConverterDriver {

	public static void main(String[] args) {
		TemperatureConverter tc = new TemperatureConverter();
		double result = tc.convert(25, "C", "K");
		System.out.println("convert(25, C, K) = " + result);
	}
}
