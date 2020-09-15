package cn.itcast.execep;

public class NotEnoughException extends RuntimeException {
	public NotEnoughException() {
	}

	public NotEnoughException(String message) {
		super(message);
	}
}
