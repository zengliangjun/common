package com.yapa.api;

public interface IYapaResource {

    int[] getStyledAttributes_yapachoice();
    // StyledAttribute
    int getStyledAttribute_yapachoice_itemSize();

    int getStyledAttribute_yapachoice_groupSize();

    int getStyledAttribute_yapachoice_position();

    int getStyledAttribute_yapachoice_lineDirection();

    // Layout
    int getLayout_yapa_root_background();
    int getLayout_yapa_root_landspace_left();
    int getLayout_yapa_root_landspace_right();
    int getLayout_yapa_root_portrait_bottom();
    int getLayout_yapa_root_portrait_top();
    int getLayout_yapa_control_layout();
    int getLayout_yapa_control_system();
    int getLayout_yapa_control_group();
    int getLayout_yapa_control_screen();
    int getLayout_yapa_control_size();
    // View
    int getView_com_yapa_internal_view_YapaView();
    int getView_com_yapa_internal_layout_YapaStackLayout();
    int getView_space_control();
    int getView_yapa_system();
    int getView_yapa_screen();
    int getView_yapa_size();
    int getView_yapa_fullscreen();
    int getView_yapa_increase_width();
    int getView_yapa_reduce_width();
    int getView_yapa_increase_height();
    int getView_yapa_reduce_height();
    int getView_yapa_increase_deep();
    int getView_yapa_reduce_deep();
    int getView_space_resetsize();
    int getView_yapa_group();
    int getView_yapa_spacecontrol();
    int getView_yapa_camera_projection();
    int getView_yapa_camera_rotation();
    int getView_yapa_calibration();
    int getView_yapa_back();
    int getView_yapa_screennumber_control();
    int getView_yapa_visible_control();
    int getView_yapa_window_control();
    int getView_yapa_screenshape_control();
    int getView_yapa_rotation_control();
    int getView_yapa_background_control();
    // Drawable
    int getDrawable_space_exit();
    int getDrawable_space_enter();
    int getDrawable_space_perespective();
    int getDrawable_space_ortho();
    int getDrawable_space_camera();
    int getDrawable_space_camera_rotation();
    int getDrawable_fullscreen_locked();
    int getDrawable_fullscreen_unlocked();
    int getDrawable_space_screentwo();
    int getDrawable_space_screenone();
    int getDrawable_space_windowshow();
    int getDrawable_space_windowhide();
    int getDrawable_space_windowsingle();
    int getDrawable_space_windowmulti();
    int getDrawable_space_screenplan();
    int getDrawable_space_screencurve();
    int getDrawable_space_windowrotation();
    int getDrawable_space_windownorotation();
    int getDrawable_space_windowrotation_y();
    int getDrawable_space_windowrotation_x();
    int getDrawable_space_windowrotation_z();
    int getDrawable_space_transparent();
    int getDrawable_space_opaque();
}
