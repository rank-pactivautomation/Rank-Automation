package com.pactiv.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class avepoint Exception
 */
@SuppressWarnings("serial")
public class PactivException extends Exception {

	/** The message. */
	private String message = null;

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(PactivException.class);

	/**
	 * Instantiates a new avepoint exception.
	 */
	public PactivException() {
		super();
	}

	/**
	 * Instantiates a new avepoint exception.
	 *
	 * @param message
	 *            the message
	 */
	public PactivException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * Instantiates a new avepoint exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public PactivException(Throwable cause) {
		super(cause);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return message;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}
}
