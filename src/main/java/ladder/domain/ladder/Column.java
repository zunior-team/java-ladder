package ladder.domain.ladder;

import ladder.domain.ladder.strategy.footstep.FootStepCreateStrategy;

import java.util.Objects;

//사다리 기둥
public class Column {
     private final FootStep footStep;

     private Column(final FootStepCreateStrategy footStepCreateStrategy) {
          this.footStep = FootStep.init(footStepCreateStrategy);
     }

     public Column(final FootStep footStep) {
          this.footStep = footStep;
     }

     public static Column init(final FootStepCreateStrategy footStepCreateStrategy) {
          return new Column(footStepCreateStrategy);
     }

     public Column createNext(final FootStepCreateStrategy footStepCreateStrategy) {
          return new Column(footStep.createNext(footStepCreateStrategy));
     }

     public Column createLast() {
          return new Column(footStep.createLast());
     }

     public int takeLadder(final int curPosition) {
          return footStep.moveThroughFootStep(curPosition);
     }

     public boolean toRightFootStep() {
          return footStep == FootStep.RIGHT;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Column column = (Column) o;
          return footStep == column.footStep;
     }

     @Override
     public int hashCode() {
          return Objects.hash(footStep);
     }
}
