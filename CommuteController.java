package commuteTime;

import commuteTime.view.input.MainInputFrame;
import commuteTime.view.result.MainResultFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommuteController {
    private CommuteModel model;
    private MainInputFrame inputView;
    private MainResultFrame resultView;

    public CommuteController(CommuteModel model, MainInputFrame inputView, MainResultFrame resultView) {
        this.model = model;
        this.inputView = inputView;
        this.resultView = resultView;

        // View에서 발생한 이벤트 처리를 위한 리스너를 등록한다.
        inputView.addSubmitButtonListener(new SubmitButtonListener());
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
            model.calculateCommuteTime();
            double commuteCost = model.calculateCommuteCost();
//            resultView.displayCommuteCost(commuteCost);
            resultView.setVisible(true);
        }
    }
}