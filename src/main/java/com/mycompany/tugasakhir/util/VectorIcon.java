package com.mycompany.tugasakhir.util;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;

/**
 * Custom Vector Icon generator wrapper for FlatSVGIcon.
 * Uses Material Design SVGs for professional, scalable rendering.
 */
public class VectorIcon extends FlatSVGIcon {

    public enum Type {
        DASHBOARD, MASUK, KELUAR, KENDARAAN, TARIF, PETUGAS, USER, LAPORAN, LOGOUT,
        SEARCH, SAVE, DELETE, RESET, PRINT
    }

    private final Type type;

    public VectorIcon(Type type) {
        this(type, 18, 18, null);
    }

    public VectorIcon(Type type, int size) {
        this(type, size, size, null);
    }

    public VectorIcon(Type type, int size, Color color) {
        this(type, size, size, color);
    }

    public VectorIcon(Type type, int width, int height, Color color) {
        super("icons/" + type.name().toLowerCase() + ".svg", width, height);
        this.type = type;
        if (color != null) {
            ColorFilter filter = new ColorFilter(c -> color);
            this.setColorFilter(filter);
        }
    }

    public Type getType() {
        return type;
    }
}
