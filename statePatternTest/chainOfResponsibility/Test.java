package chainOfResponsibility;

public class Test {

    public static void main(String[] args) {
      CallHandlerBase reception = new ReceptionHandler();
      CallHandlerBase admin = new AdministrativeOfficeHandler();
      CallHandlerBase manager = new ManagerHandler();
      CallHandlerBase auto = new AutomatedSpeakerHandler();

      reception.setRedirect(admin);
      admin.setRedirect(manager);
      manager.setRedirect(auto);

      PhoneCall call1 = new PhoneCall(1, "9876543210",
         PhoneCallResponse.ACCEPTED);
      PhoneCall call2 = new PhoneCall(2, "9182736451",
         PhoneCallResponse.ACCEPTED);

      reception.setStatus(Status.ONDESK);

      reception.response(call1);

      reception.setStatus(Status.OFFDESK);
      admin.setStatus(Status.OFFDESK);
      manager.setStatus(Status.OFFDESK);
      reception.response(call2);
   }
}
