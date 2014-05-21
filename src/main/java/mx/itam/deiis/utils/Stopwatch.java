package mx.itam.deiis.utils;

public class Stopwatch {
	private long 	StartTime;
	private long 	EndTime;
	private double	Time;
	
	public Stopwatch() {
	}
	public Stopwatch(boolean start) {
		if(start) {
			Start();
		}
	}
	
	public void Start() {
		StartTime = System.currentTimeMillis();
		EndTime = StartTime;
	}
	
	public double Stop() {
		EndTime = System.currentTimeMillis();
		Time = (EndTime - StartTime) / 1000.0;
		return Time;
	}
	
	public void Reset() {
		StartTime = 0;
		EndTime = 0;
		Time = 0;
	}
	
	public double getTime(){
		return Time;
	}
}
