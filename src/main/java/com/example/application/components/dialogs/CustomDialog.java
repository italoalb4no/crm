package com.example.application.components.dialogs;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.ArrayList;
import java.util.List;

public class CustomDialog extends Dialog {

    private List<HorizontalLayout> headersList;
    private List<Avatar> avatarList;

    public CustomDialog() {
    }

    public CustomDialog(
            boolean setCloseOnEsc,
            boolean setCloseOnOutsideClick,
            boolean setDraggable,
            boolean setResizable,
            String title) {
        this.setCloseOnEsc(setCloseOnEsc);
        this.setCloseOnOutsideClick(setCloseOnOutsideClick);
        this.setDraggable(setDraggable);
        this.setResizable(setResizable);
        Button closeBtn = new Button(VaadinIcon.CLOSE.create(), e -> this.close());
        closeBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        closeBtn.addClassName(LumoUtility.Margin.Left.AUTO);
        this.setHeaderTitle(title);
        this.getHeader().add(closeBtn);
    }

    public CustomDialog(
            boolean setCloseOnEsc,
            boolean setCloseOnOutsideClick,
            boolean setDraggable,
            boolean setResizable) {
        this.setCloseOnEsc(setCloseOnEsc);
        this.setCloseOnOutsideClick(setCloseOnOutsideClick);
        this.setDraggable(setDraggable);
        this.setResizable(setResizable);
    }

    protected void setHeader(List<String> sections) {
        this.headersList = new ArrayList<>();
        this.avatarList = new ArrayList<>();

        for (int i = 0; i < sections.size(); i++) {
            Avatar avatar = new Avatar(String.valueOf(i + 1));
            avatar.addClassNames(LumoUtility.FontWeight.MEDIUM);
            this.avatarList.add(avatar);
            Span title = new Span(sections.get(i));
            HorizontalLayout header = new HorizontalLayout(avatar, title);
            header.setAlignItems(FlexComponent.Alignment.CENTER);

            if (i == 0) {
                header.addClassNames(LumoUtility.Margin.Left.AUTO);
            } else {
                avatar.addClassNames(LumoUtility.Margin.Left.SMALL);
            }

            this.getHeader().add(header);
            this.headersList.add(header);
        }

        Icon crossIcon = new Icon(VaadinIcon.CLOSE);
        Button closeBtn = new Button(crossIcon,
                (e) -> this.close());
        closeBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        closeBtn.addClassName(LumoUtility.Margin.Left.AUTO);

        this.getHeader().add(closeBtn);
    }

    protected void highlightSection(int index) {
        int i = 0;
        for (HorizontalLayout header : this.headersList) {
            header.getStyle().set("color", "black");
            header.removeClassName(LumoUtility.FontWeight.BOLD);

            if (i == index) {
                header.addClassName(LumoUtility.FontWeight.BOLD);
                this.avatarList.get(i).getStyle()
                        .set("background", "#5D60EF")
                        .set("color", "white");
            } else {
                this.avatarList.get(i).getStyle()
                        .set("background", "#eeeeec")
                        .set("color", "black");
            }
            i++;
        }


    }

}
