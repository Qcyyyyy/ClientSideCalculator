package net.Qcy.ClientSideCalculator.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalcGUI extends Screen {

    String ans = "";

    public CalcGUI() {
        super(Component.literal("Calculator"));
    }

    @Override
    protected void init() {
        super.init();

        int cH = this.height / 2; // Height / y coord center of screen
        int cW = this.width / 2; // Width / x coord center of screen

        int zH = cH - 10 + 50; // Height pos of zero button
        int zW = cW - 10; // Width pos of Zero button

        EditBox calcField = new EditBox(font, cW - 100, cH - 100, 200, 20, title);
        calcField.setValue("");
        this.addRenderableWidget(calcField);

        Button button0 = new Button.Builder(Component.literal("0"),
                btn -> calcField.setValue(calcField.getValue() + "0"))
                .pos(zW, zH)
                .size(20, 20)
                .build();
        this.addRenderableWidget(button0);

        Button button1 = new Button.Builder(Component.literal("1"),
                btn -> calcField.setValue(calcField.getValue() + "1"))
                .pos(zW - 22, zH - 22)
                .size(20, 20)
                .build();
        this.addRenderableWidget(button1);

        Button button2 = new Button.Builder(Component.literal("2"),
                btn -> calcField.setValue(calcField.getValue() + "2"))
                .pos(zW, zH - 22)
                .size(20, 20)
                .build();
        this.addRenderableWidget(button2);

        Button button3 = new Button.Builder(Component.literal("3"),
                btn -> calcField.setValue(calcField.getValue() + "3"))
                .pos(zW + 22, zH - 22)
                .size(20, 20)
                .build();
        this.addRenderableWidget(button3);

        Button button4 = new Button.Builder(Component.literal("4"),
                btn -> calcField.setValue(calcField.getValue() + "4"))
                .pos(zW - 22, zH - 44)
                .size(20, 20)
                .build();
        this.addRenderableWidget(button4);

        Button button5 = new Button.Builder(Component.literal("5"),
                btn -> calcField.setValue(calcField.getValue() + "5"))
                .pos(zW, zH - 44)
                .size(20, 20)
                .build();
        this.addRenderableWidget(button5);

        Button button6 = new Button.Builder(Component.literal("6"),
                btn -> calcField.setValue(calcField.getValue() + "6"))
                .pos(zW + 22, zH - 44)
                .size(20, 20)
                .build();
        this.addRenderableWidget(button6);

        Button button7 = new Button.Builder(Component.literal("7"),
                btn -> calcField.setValue(calcField.getValue() + "7"))
                .pos(zW - 22, zH - 66)
                .size(20, 20)
                .build();
        this.addRenderableWidget(button7);

        Button button8 = new Button.Builder(Component.literal("8"),
                btn -> calcField.setValue(calcField.getValue() + "8"))
                .pos(zW, zH - 66)
                .size(20, 20)
                .build();
        this.addRenderableWidget(button8);

        Button button9 = new Button.Builder(Component.literal("9"),
                btn -> calcField.setValue(calcField.getValue() + "9"))
                .pos(zW + 22, zH - 66)
                .size(20, 20)
                .build();
        this.addRenderableWidget(button9);

        Button buttonDec = new Button.Builder(Component.literal("."),
                btn -> calcField.setValue(calcField.getValue() + "."))
                .pos(zW + 22, zH)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonDec);

        Button buttonEq = new Button.Builder(Component.literal("="),
                btn -> calcField.setValue(getResult(calcField.getValue())))
                .pos(zW + 44, zH)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonEq);

        Button buttonLB = new Button.Builder(Component.literal("("),
                btn -> calcField.setValue(calcField.getValue() + "("))
                .pos(zW - 22, zH - 88)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonLB);

        Button buttonRB = new Button.Builder(Component.literal(")"),
                btn -> calcField.setValue(calcField.getValue() + ")"))
                .pos(zW, zH - 88)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonRB);

        Button buttonPlus = new Button.Builder(Component.literal("+"),
                btn -> calcField.setValue(calcField.getValue() + "+"))
                .pos(zW + 44, zH - 22)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonPlus);

        Button buttonMinus = new Button.Builder(Component.literal("-"),
                btn -> calcField.setValue(calcField.getValue() + "-"))
                .pos(zW + 44, zH - 44)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonMinus);

        Button buttonMulti = new Button.Builder(Component.literal("*"),
                btn -> calcField.setValue(calcField.getValue() + "*"))
                .pos(zW + 44, zH - 66)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonMulti);

        Button buttonDiv = new Button.Builder(Component.literal("/"),
                btn -> calcField.setValue(calcField.getValue() + "/"))
                .pos(zW + 44, zH - 88)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonDiv);

        Button buttonExp = new Button.Builder(Component.literal("^"),
                btn -> calcField.setValue(calcField.getValue() + "^"))
                .pos(zW + 22, zH - 88)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonExp);

        Button buttonClear = new Button.Builder(Component.literal("C"),
                btn -> calcField.setValue(""))
                .pos(zW + 66, zH - 88)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonClear);

        Button buttonBackSp = new Button.Builder(Component.literal("<-"),
                btn -> calcField.setValue(backspace(calcField.getValue())))
                .pos(zW + 66, zH - 66)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonBackSp);

        Button buttonAns = new Button.Builder(Component.literal("AN"),
                btn -> calcField.setValue(calcField.getValue() + ans))
                .pos(zW - 22, zH)
                .size(20, 20)
                .build();
        this.addRenderableWidget(buttonAns);

        Button buttonPrint = new Button.Builder(Component.literal("Print"),
                btn -> Minecraft.getInstance().player.sendSystemMessage(Component.literal(ans)))
                .pos(zW - 74, zH)
                .size(50, 20)
                .build();
        this.addRenderableWidget(buttonPrint);

    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics, mouseY, mouseY, partialTick);
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void onClose() {
        super.onClose();
    }

    @Override
    public void removed() {
        super.removed();
    }

    // Calcs result of string equation for calculator after eq button pressed
    private String getResult(String equation) {
        try {
            Expression expression = new ExpressionBuilder(equation).build();
            double result = expression.evaluate();
            // Accounting for floating point precision error and Regex to remove trailing
            // zeroes from whole numbers Eg 28.0 to 28
            String resString = (Math.abs(result - Math.round(result)) < 1e-10 ? String.format("%.0f", result)
                    : String.valueOf(result));
            ans = resString.replaceAll("\\.0+$", "");
            return ans;
        } catch (Exception e) {
            return "ERROR";
        }
    }

    // Backspace method to catch any potential attempting to backspace empty string
    private String backspace(String equation) {
        if (equation == "") {
            return equation;
        }
        return equation.substring(0, equation.length() - 1);
    }

}