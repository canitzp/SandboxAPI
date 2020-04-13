package org.sandboxpowered.api.util.nbt;

public enum NbtType {
	END(0),
	BYTE(1),
	SHORT(2),
	INT(3),
	LONG(4),
	FLOAT(5),
	DOUBLE(6),
	BYTE_ARRAY(7),
	STRING(8),
	LIST(9),
	COMPOUND(10),
	INT_ARRAY(11),
	LONG_ARRAY(12),
	NUMBER(99),
	UNKNOWN(-1);

	private int id;

	NbtType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static NbtType fromId(int id) {
		for (NbtType type : values()) {
			if (id == type.id) return type;
		}
		return UNKNOWN;
	}
}
