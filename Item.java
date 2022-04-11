package uk.ac.aston.oop.javafx.assessed.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The Item class represents a multi-media item. Information about the item is
 * stored and can be retrieved. This class serves as a superclass for more
 * specific itms.
 * 
 */
public abstract class Item {
	private final String title;
	private final int playingTime;
	private BooleanProperty gotIt = new SimpleBooleanProperty(false);
	private StringProperty comment = new SimpleStringProperty("");

	/**
	 * Initialise the fields of the item.
	 */
	public Item(String theTitle, int time) {
		title = theTitle;
		playingTime = time;
	}

	/**
	 * Enter a comment for this item.
	 */
	public void setComment(String comment) {
		this.comment.set(comment);
	}

	/**
	 * Return the comment for this item.
	 */
	public String getComment() {
		return comment.get();
	}

	/**
	 * Return the comment property for this item.
	 */
	public StringProperty commentProperty() {
		return comment;
	}

	/**
	 * Set the flag indicating whether we own this item.
	 */
	public void setOwn(boolean ownIt) {
		gotIt.set(ownIt);
	}

	/**
	 * Return information whether we own a copy of this item.
	 */
	public boolean getOwn() {
		return gotIt.get();
	}

	/**
	 * Return the "own it" property for this item.
	 */
	public BooleanProperty ownProperty() {
		return gotIt;
	}

	/**
	 * Returns the playing time for this item.
	 */
	public int getPlayingTime() {
		return playingTime;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(
			String.format("title: %s (%d mins)", title, playingTime));
		if (gotIt.get()) {
			sb.append("*");
		}
		sb.append("\n");
		sb.append("    " + comment.get() + "\n\n");
		return sb.toString();
	}
}
