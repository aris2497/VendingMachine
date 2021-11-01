package com.company.view;

import com.company.service.Exceptions.InsufficientFundsException;
import com.company.service.Exceptions.MoneyFormatException;
import com.company.service.Exceptions.NoItemInventoryException;
import com.company.service.Exceptions.ZeroFundsException;

import java.util.Scanner;

public class VendingConsoleImpl implements UserIO{

    final private Scanner console = new Scanner(System.in);

    /**
     * A very simple method that takes in a message to display on the console
     * and then waits for a integer answer from the user to return.
     *
     * @param msg - String of information to display to the user.
     */
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    /**
     * A simple method that takes in a message to display on the console,
     * and then waits for an answer from the user to return.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as string
     */
    /*@Override
    public String readString(String msgPrompt) {
        System.out.println(msgPrompt);
        return console.nextLine();
    }*/

    /**
     * A simple method that takes in a message to display on the console,
     * and continually reprompts the user with that message until they enter an integer
     * to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as integer
     */
    @Override
    public String readMoneyInput(String msgPrompt) {
        boolean invalidInput = true;
        Double num = 0.0;

        while (invalidInput) {
            try {
                String stringValue = this.readString(msgPrompt);
                // Get the input line, and try and parse
                num = Double.parseDouble(stringValue); // if it's 'bob' it'll break
                if (num==0){
                    invalidInput = true;
                    throw new ZeroFundsException();
                }
                else {
                    invalidInput = false;
                }
            } catch (NumberFormatException ex){
                invalidInput = true;
                //System.out.println("Money has wrong format");
            }
            catch (ZeroFundsException ex){
                ex.howToRecover();
            }
        }
        String output = Double.toString(num);
        return output;
    }

    /**
     * A slightly more complex method that takes in a message to display on the console,
     * and continually reprompts the user with that message until they enter an integer
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @param min       - minimum acceptable value for return
     * @param max       - maximum acceptable value for return
     * @return an integer value as an answer to the message prompt within the min/max range
     */
    @Override
    public int readItemIndex(String msgPrompt, int min, int max) {
        boolean invalidInput = true;
        int num = 0;

        while (invalidInput) {
            try {
                String stringValue = this.readString(msgPrompt);
                num = Integer.parseInt(stringValue);  // Get the input line, and try and parse
                if (num < min || num > max) {
                    invalidInput = true;
                    throw new NoItemInventoryException();
                } else {
                    invalidInput = false;
                }
            } catch (NoItemInventoryException err) {
                err.howtoRecover(num);
            }
        }
        return num;
    }

    /**
     * A simple method that takes in a message to display on the console,
     * and continually reprompts the user with that message until they enter a long
     * to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as long
     */
    @Override
    public long readLong(String msgPrompt) {
        while (true) {
            try {
                return Long.parseLong(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    /**
     * A slightly more complex method that takes in a message to display on the console,
     * and continually reprompts the user with that message until they enter a double
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @param min       - minimum acceptable value for return
     * @param max       - maximum acceptable value for return
     * @return an long value as an answer to the message prompt within the min/max range
     */
    @Override
    public long readLong(String msgPrompt, long min, long max) {
        long result;
        do {
            result = readLong(msgPrompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public String readString(String msgPrompt) {
        System.out.println(msgPrompt);
        return console.nextLine();
    }

    /**
     * A simple method that takes in a message to display on the console,
     * and continually reprompts the user with that message until they enter a float
     * to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as float
     */
    @Override
    public float readFloat(String msgPrompt) {
        while (true) {
            try {
                return Float.parseFloat(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    /**
     * A slightly more complex method that takes in a message to display on the console,
     * and continually reprompts the user with that message until they enter a float
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @param min       - minimum acceptable value for return
     * @param max       - maximum acceptable value for return
     * @return an float value as an answer to the message prompt within the min/max range
     */
    @Override
    public float readFloat(String msgPrompt, float min, float max) {
        float result;
        do {
            result = readFloat(msgPrompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public int readItemIndex(String prompt) {
        return 0;
    }

    /**
     * A simple method that takes in a message to display on the console,
     * and continually reprompts the user with that message until they enter a double
     * to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as double
     */
    @Override
    public double readDouble(String msgPrompt) {
        while (true) {
            try {
                return Double.parseDouble(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    /**
     * A slightly more complex method that takes in a message to display on the console,
     * and continually reprompts the user with that message until they enter a double
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @param min       - minimum acceptable value for return
     * @param max       - maximum acceptable value for return
     * @return an double value as an answer to the message prompt within the min/max range
     */
    @Override
    public double readDouble(String msgPrompt, double min, double max) {
        double result;
        do {
            result = readDouble(msgPrompt);
        } while (result < min || result > max);
        return result;
    }

}
