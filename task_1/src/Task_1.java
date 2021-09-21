public class Task_1 implements Task_1_base {
    @Override
    public int subtask_1_if(int first, int second, int third) {
        if ((first < second) & (first < third)) {
            return first;
        }
        else if (second < third) {
            return second;
        }
        else {
            return third;
        }
    }

    @Override
    public boolean subtask_2_if(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) | (year % 400 == 0)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int subtask_3_if(double x, double y, double left_up_x, double left_up_y, double width, double height) {
        double right_up_x = left_up_x + width;
        double left_down_y = left_up_y - height;
        if ((y < left_up_y && y > left_down_y) & (x > left_up_x && x < right_up_x)) {
            return 1;
        } else if (x <= 0 & y <= 0) {
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public int subtask_4_if(double x0, double y0, double k, double b) {
        if (y0 == (k * x0) + b) {
            return 2;
        } else if (y0 < (k * x0) + b) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String subtask_5_switch(int day_od_week) {
        String day = "";
        switch (day_od_week) {
            case 1:
                day = "Понедельник";
                break;
            case 2:
                day = "Вторник";
                break;
            case 3:
                day = "Среда";
                break;
            case 4:
                day = "Четверг";
                break;
            case 5:
                day = "Пятница";
                break;
            case 6:
                day = "Суббота";
                break;
            case 7:
                day = "Воскресенье";
                break;
            default:
                day = "Ошибка";
                break;
        }
        return day;
    }
    @Override
    public String subtask_6_switch(int direction) {
        String dir = "";
        switch (direction) {
            case 1:
                dir = "север";
                break;
            case 2:
                dir = "юг";
                break;
            case 3:
                dir = "запад";
                break;
            case 4:
                dir = "восток";
                break;
            default:
                dir = "";
        }
        return dir;
    }

    @Override
    public int subtask_7_if(double vx, double vy, double vz, double speed, double time, double wall) {
        double st = speed * time;
        if (vx == 0 & vy == 0 & vz == 0) {
            return 2;
        }
        if (vx * st == wall & vy * st == wall & vz * st == wall) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int subtask_8_if(double k1, double b1, double k2, double b2) {
        if (k1 + b1 == k2 + b2) {
            return 3;
        }
        if (k1 == k2) {
            return 1;
        } else {
            return 2;
        }
    }
}