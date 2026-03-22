public class Clock {

    private int horas;
    private int minutos;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23) {
            throw new IllegalArgumentException("Hora invalida: " + h);
        }
        if (m < 0 || m > 59) {
            throw new IllegalArgumentException("Minuto invalido: " + m);
        }
        horas = h;
        minutos = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s == null || s.length() != 5 || s.charAt(2) != ':') {
            throw new IllegalArgumentException("Formato invalido: " + s);
        }

        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                throw new IllegalArgumentException("Formato invalido: " + s);
            }
        }

        horas   = Integer.parseInt(s.substring(0, 2));
        minutos = Integer.parseInt(s.substring(3, 5));

        if (horas < 0 || horas > 23) {
            throw new IllegalArgumentException("Hora invalida: " + horas);
        }
        if (minutos < 0 || minutos > 59) {
            throw new IllegalArgumentException("Minuto invalido: " + minutos);
        }
    }
    // Returns a string representation of this clock, using the format HH:MM
    public String toString() {
        return String.format("%02d:%02d", horas, minutos);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.horas != that.horas) {
            return this.horas < that.horas;
        }
        return this.minutos < that.minutos;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        minutos++;
        if (minutos == 60) {
            minutos = 0;
            horas++;
        }
        if (horas == 24) {
            horas = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Delta nao pode ser negativo");
        }
        int totalMinutos = horas * 60 + minutos + delta;
        totalMinutos = totalMinutos % (24 * 60);
        horas   = totalMinutos / 60;
        minutos = totalMinutos % 60;
    }

    // Test client
    public static void main(String[] args) {
        Clock c1 = new Clock(6, 0);
        Clock c2 = new Clock("23:59");

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        System.out.println("c1 eh mais cedo que c2? " + c1.isEarlierThan(c2));

        c1.tic();
        System.out.println("c1 depois do tic: " + c1);

        c2.tic();
        System.out.println("c2 depois do tic (virada): " + c2);

        c1.toc(60);
        System.out.println("c1 depois de +60 min: " + c1);
    }
}
