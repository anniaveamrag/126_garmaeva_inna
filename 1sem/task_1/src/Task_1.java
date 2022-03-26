public class Task_1 implements Task_1_base {
    @Override
    public int subtask_1_if(int first, int second, int third) {
        if ((first < second) & (first < third)) {
            return first;
        } else if (second < third) {
            return second;
        } else {
            return third;
        }
    }

    @Override
    public boolean subtask_2_if(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) | (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int subtask_3_if(double x, double y, double left_up_x, double left_up_y, double width, double height) {
        double x1 = left_up_x + width;
        double y1 = left_up_y - height;
        if (width < 0.000001 || height < 0.000001)
            return 2;
        if(x1 - x < 0.000001 || x - left_up_x < 0.000001 )
            return 0;
        if(y - y1 < 0.000001 || left_up_y - y < 0.000001 )
            return 0;
        return 1;
    }
    @Override
    public int subtask_4_if(double x0, double y0, double k, double b) {
        double x = k*x0 + b;
        if (Math.abs(x - y0) < 0.000001)
            return 2;
        if (x - y0 < 0)
            return 0;
        if (x - y0 > 0)
            return 1;
        return -1;
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
        if ((speed < 0.000001) || (time < 0.000001)) {
            return 2;
        } else if ((Math.sqrt(wall * wall + (wall * vy / vx) * (wall * vy / vx) + (wall * vz / vx) * (wall * vz / vx)) / speed) - time <= 0.000001) {
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