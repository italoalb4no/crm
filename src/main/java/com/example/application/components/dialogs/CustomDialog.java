package com.example.application.components.dialogs;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.ArrayList;
import java.util.List;

public class CustomDialog extends Dialog {

    private List<Avatar> numbers;
    private List<Span> sectionTitles;

    public CustomDialog() {
    }

    public CustomDialog(boolean setCloseOnEsc, boolean setCloseOnOutsideClick, boolean setDraggable, boolean setResizable, String title) {
        this.setCloseOnEsc(setCloseOnEsc);
        this.setCloseOnOutsideClick(setCloseOnOutsideClick);
        this.setDraggable(setDraggable);
        this.setResizable(setResizable);
        Button closeBtn = new Button(VaadinIcon.CLOSE.create(), e -> this.close());
        this.setHeaderTitle(title);
        this.getHeader().add(closeBtn);
    }

    public CustomDialog(boolean setCloseOnEsc, boolean setCloseOnOutsideClick, boolean setDraggable, boolean setResizable) {
        this.setCloseOnEsc(setCloseOnEsc);
        this.setCloseOnOutsideClick(setCloseOnOutsideClick);
        this.setDraggable(setDraggable);
        this.setResizable(setResizable);
    }

    protected void setHeader(List<String> sections) {

        this.numbers = new ArrayList<>();
        this.sectionTitles = new ArrayList<>();

        for (int i = 0; i < sections.size(); i++) {
            Avatar number = new Avatar(String.valueOf(i + 1));
            Span span = new Span(sections.get(i));
            if (i != 0) {
                number.addClassNames(LumoUtility.FontWeight.MEDIUM, LumoUtility.Margin.Left.SMALL);
            } else {
                number.addClassName(LumoUtility.Margin.Left.AUTO);
            }
            span.addClassNames(LumoUtility.FontWeight.MEDIUM, LumoUtility.Margin.Left.SMALL);

            this.numbers.add(number);
            this.sectionTitles.add(span);

            this.getHeader().add(number, span);

        }

        Icon crossIcon = new Icon(VaadinIcon.CLOSE);
        Button closeBtn = new Button(crossIcon,
                (e) -> this.close());
        closeBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        closeBtn.addClassName(LumoUtility.Margin.Left.AUTO);

        this.getHeader().add(closeBtn);
    }

    protected void highlightSection(int index) {
        for (int i = 0; i < this.sectionTitles.size(); i++) {
            if (i + 1 == index) {
                this.numbers.get(i).getStyle().set("background", "#5D60EF").set("color", "white");
                this.sectionTitles.get(i).getStyle().set("color", "#5D60EF");
                this.sectionTitles.get(i).addClassName(LumoUtility.FontWeight.BOLD);
            } else {
                this.numbers.get(i).getStyle().set("background", "#E8EBEE").set("color", "black");
                this.sectionTitles.get(i).getStyle().set("color", "black");
                this.sectionTitles.get(i).removeClassName(LumoUtility.FontWeight.BOLD);
            }
        }
    }

}
