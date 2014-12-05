package visitor;

import shapes.Difference;
import shapes.Ellipse;
import shapes.Intersection;
import shapes.Rectangle;
import shapes.Rotated;
import shapes.Shape;
import shapes.Translated;
import shapes.Union;

/**
 *
 * @author Michał Szura
 */
public class ShapePrintVisitor implements Visitator {

    @Override
    public void visit(Difference v) {

        String output = v.print();
        int indent = 0;
        String[] lines = output.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < indent; j++) {
                lines[i] = "\t" + lines[i];
            }
            System.out.print(lines[i].replaceAll("\\+|>|\\|", ""));
            System.out.println();
            if (lines[i].contains(">")) {
                indent++;
            }
            if (lines[i].contains("|")) {
                indent--;
            }
            if (lines[i].contains("+")) {
                indent--;
            }
        }
    }

    @Override
    public void visit(Ellipse v) {
        String output = v.print();
        int indent = 0;
        String[] lines = output.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < indent; j++) {
                lines[i] = "\t" + lines[i];
            }
            System.out.print(lines[i].replaceAll("\\+|>|\\|", ""));
            System.out.println();
            if (lines[i].contains(">")) {
                indent++;
            }
            if (lines[i].contains("|")) {
                indent--;
            }
            if (lines[i].contains("+")) {
                indent--;
            }
        }
    }

    @Override
    public void visit(Intersection v) {
        String output = v.print();
        int indent = 0;
        String[] lines = output.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < indent; j++) {
                lines[i] = "\t" + lines[i];
            }
            System.out.print(lines[i].replaceAll("\\+|>|\\|", ""));
            System.out.println();
            if (lines[i].contains(">")) {
                indent++;
            }
            if (lines[i].contains("|")) {
                indent--;
            }
            if (lines[i].contains("+")) {
                indent--;
            }
        }
    }

    @Override
    public void visit(Rectangle v) {
        String output = v.print();
        int indent = 0;
        String[] lines = output.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < indent; j++) {
                lines[i] = "\t" + lines[i];
            }
            System.out.print(lines[i].replaceAll("\\+|>|\\|", ""));
            System.out.println();
            if (lines[i].contains(">")) {
                indent++;
            }
            if (lines[i].contains("|")) {
                indent--;
            }
            if (lines[i].contains("+")) {
                indent--;
            }
        }
    }

    @Override
    public void visit(Rotated v) {
        String output = v.print();
        int indent = 0;
        String[] lines = output.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < indent; j++) {
                lines[i] = "\t" + lines[i];
            }
            System.out.print(lines[i].replaceAll("\\+|>|\\|", ""));
            System.out.println();
            if (lines[i].contains(">")) {
                indent++;
            }
            if (lines[i].contains("|")) {
                indent--;
            }
            if (lines[i].contains("+")) {
                indent--;
            }
        }
    }

    @Override
    public void visit(Translated v) {
        String output = v.print();
        int indent = 0;
        String[] lines = output.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < indent; j++) {
                lines[i] = "\t" + lines[i];
            }
            System.out.print(lines[i].replaceAll("\\+|>|\\|", ""));
            System.out.println();
            if (lines[i].contains(">")) {
                indent++;
            }
            if (lines[i].contains("|")) {
                indent--;
            }
            if (lines[i].contains("+")) {
                indent--;
            }
        }
    }

    @Override
    public void visit(Union v) {
        String output = v.print();
        int indent = 0;
        String[] lines = output.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < indent; j++) {
                lines[i] = "\t" + lines[i];
            }
            System.out.print(lines[i].replaceAll("\\+|>|\\|", ""));
            System.out.println();
            if (lines[i].contains(">")) {
                indent++;
            }
            if (lines[i].contains("|")) {
                indent--;
            }
            if (lines[i].contains("+")) {
                indent--;
            }
        }
    }

}
