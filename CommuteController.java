package commuteTime;

import commuteTime.view.input.MainInputFrame;
import commuteTime.view.result.MainResultFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CommuteController {
    private CommuteModel model;
    private MainInputFrame inputView;
    private MainResultFrame resultView;

    public CommuteController(CommuteModel model, MainInputFrame inputView, MainResultFrame resultView) {
        this.model = model;
        this.inputView = inputView;
        this.resultView = resultView;

        // 소요시간 정보를 얻어오기 위한 리스너를 등록한다.
        inputView.addRequiredTimeButtonListener(new DurationButtonListener());

        // View에서 발생한 이벤트 처리를 위한 리스너를 등록한다.
        inputView.addSubmitButtonListener(new SubmitButtonListener());
    }

    class DurationButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("소요시간을 가져오기 위한 이벤트 리스너가 트리거됨");

        }
    }

    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 사용자 입력 값을 Model에 전달한다.
            double hourlyWage = inputView.getWage();
            String departureLocation = inputView.getDepartureLocation();
            String destinationLocation = inputView.getDestinationLocation();

            model.setHourlyWage(hourlyWage);
            model.setDepartureLocation(departureLocation);
            model.setDestinationLocation(destinationLocation);

            // Model에서 계산된 결과를 View에 전달한다.
            try {
                model.calculateCommuteTime();
                inputView.setDuration(model.duration);
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            int commuteCost = model.calculateCommuteCost();
            String departure = model.getDepartureName();
            String destination = model.getDestinationName();
            int fare = model.getFare();

            resultView.setDeparture(departure);
            resultView.setDestination(destination);
            resultView.setCommuteCost(commuteCost);
            resultView.setFare(fare);

//            resultView.displayCommuteCost(commuteCost);
            resultView.createResultFrame();
            resultView.setVisible(true);
        }
    }
}