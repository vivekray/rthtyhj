package com.ray.algorithm;

public class NotesCount {
	
		static int I, TOTAL;

		/*
		 * Static array to store values of notes
		 */
		static int[] NOTES = { 1000, 500, 100, 50, 10, 5, 2, 1 };

		/**
		 * Function to find the notes and print the output
		 * 
		 * @param value the amount to which the note to despenced
		 */
		static void notes(int value) {
			if (value / NOTES[I] != 0) {
				TOTAL += (value / NOTES[I]);
				System.out.println(NOTES[I] + "rs notes :" + value / NOTES[I]);
				value = value % NOTES[I];
			}
			I++;
			if (value == 0) {
				System.out.println("total notes :" + TOTAL);
				return;
			}

			notes(value);

		}

		
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		notes(578483);

	}

}
