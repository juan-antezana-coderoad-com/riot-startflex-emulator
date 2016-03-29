package com.tierconnect.riot.bridges.emulators.datagen.starflexgen.model;

import com.google.common.base.Preconditions;
import com.tierconnect.riot.bridges.emulators.utils.JsonUtils;

import java.io.Serializable;

/**
 * Created by jantezana on 3/21/16.
 */
public class StarFlexData implements StarFlex {

    private String macId;

    private TagReadDataMessage tagReadDataMessage;

    /**
     * Builds an instance of StarFlexData.
     *
     * @param builder the StarFlexDataBuilder
     */
    private StarFlexData(final StarFlexDataBuilder builder) {
        Preconditions.checkNotNull(builder);
        this.macId = builder.getMacId();
        this.tagReadDataMessage = builder.getTagReadDataMessage();
    }

    @Override
    public String getHeader() {
        return HEADER;
    }


    @Override
    public String getTopic() {
        return String.format("%s/%s/data", this.getHeader(), this.getMacId());
    }

    @Override
    public String getMessage() {
        return String.format("[%s]", JsonUtils.convertObjectToJson(this.getTagReadDataMessage()));
    }

    /**
     * Gets the value of macId
     *
     * @return the value of macId
     */
    public String getMacId() {
        return macId;
    }

    /**
     * Gets the value of tagReadDataMessage
     *
     * @return the value of getTagReadDataMessage
     */
    public TagReadDataMessage getTagReadDataMessage() {
        return tagReadDataMessage;
    }

    /**
     * TagReadDataMessage class.
     *
     */
    public static class TagReadDataMessage implements Serializable {

        private String type;
        private long timestamp;
        private long seqNum;
        private String txAntennaPort;
        private String txExpanderPort;
        private String transmitSource;
        private String data;

        /**
         * Builds an instance of TagReadDataMessage
         *
         * @param builder the TagReadDataMessageBuilder
         */
        private TagReadDataMessage(final TagReadDataMessageBuilder builder) {
            type = builder.getType();
            timestamp = builder.getTimestamp();
            seqNum = builder.getSeqNum();
            txAntennaPort = builder.getTxAntennaPort();
            txExpanderPort = builder.getTxExpanderPort();
            transmitSource = builder.getTransmitSource();
            data = builder.getData();
        }

        public String getType() {
            return type;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public long getSeqNum() {
            return seqNum;
        }

        public String getTxAntennaPort() {
            return txAntennaPort;
        }

        public String getTxExpanderPort() {
            return txExpanderPort;
        }

        public String getTransmitSource() {
            return transmitSource;
        }

        public String getData() {
            return data;
        }

        /**
         * TagReadDataMessageBuilder class.
         *
         */
        public static class TagReadDataMessageBuilder {
            private static final String DATA_FORMAT = "0x3000%23d62D3";
            public static final String DEFAULT_TYPE = "TagReadData";
            public static final long DEFAULT_TIMESTAMP = 1455135473992L;
            public static final int DEFAULT_SEQ_NUMBER = 1396547;
            public static final String DEFAULT_TX_ANTENNA_PORT = "PORT_2";
            public static final String DEFAULT_TX_EXPANDER_PORT = "NONE";
            public static final String DEFAULT_TRANSMIT_SOURCE = "INTERNAL";
            public static final String DEFAULT_DATA = "0x3000AE100000000000000036708062D3";

            private String type;
            private long timestamp;
            private long seqNum;
            private String txAntennaPort;
            private String txExpanderPort;
            private String transmitSource;
            private String data;


            public String getType() {
                return type;
            }

            public long getTimestamp() {
                return timestamp;
            }

            public long getSeqNum() {
                return seqNum;
            }

            public String getTxAntennaPort() {
                return txAntennaPort;
            }

            public String getTxExpanderPort() {
                return txExpanderPort;
            }

            public String getTransmitSource() {
                return transmitSource;
            }

            public String getData() {
                return data;
            }

            public TagReadDataMessageBuilder setType(final String type) {
                this.type = type;
                return this;
            }

            public TagReadDataMessageBuilder setTimestamp(final long timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public TagReadDataMessageBuilder setSeqNum(final long seqNum) {
                this.seqNum = seqNum;
                return this;
            }

            public TagReadDataMessageBuilder setTxAntennaPort(final String txAntennaPort) {
                this.txAntennaPort = txAntennaPort;
                return this;
            }

            public TagReadDataMessageBuilder setTxExpanderPort(final String txExpanderPort) {
                this.txExpanderPort = txExpanderPort;
                return this;
            }

            public TagReadDataMessageBuilder setTransmitSource(final String transmitSource) {
                this.transmitSource = transmitSource;
                return this;
            }

            /**
             * Sets the value of data.
             *
             * @param data the new value of data
             * @return the TagReadDataMessageBuilder
             */
            public TagReadDataMessageBuilder setData(final String data) {
                this.data = data;
                return this;
            }

            /**
             * Sets all values with default values.
             *
             * @return the TagReadDataMessageBuilder
             */
            public TagReadDataMessageBuilder setDefaultValues() {
                type = DEFAULT_TYPE;
                timestamp = DEFAULT_TIMESTAMP;
                seqNum = DEFAULT_SEQ_NUMBER;
                txAntennaPort = DEFAULT_TX_ANTENNA_PORT;
                txExpanderPort = DEFAULT_TX_EXPANDER_PORT;
                transmitSource = DEFAULT_TRANSMIT_SOURCE;
                data = DEFAULT_DATA;
                return this;
            }

            /**
             * Set all values with random values.
             *
             * @return the TagReadDataMessageBuilder
             */
            public TagReadDataMessageBuilder setRandomValues() {
                return this.setDefaultValues();
            }

            /**
             * Builds a TagReadDataMessage.
             *
             * @return the TagReadDataMessage
             */
            public TagReadDataMessage build() {
                return new TagReadDataMessage(this);
            }
        }
    }

    /**
     * StarFlexDataBuilder class,
     *
     */
    public static class StarFlexDataBuilder {
        private String MacId;
        private TagReadDataMessage tagReadDataMessage;

        /**
         * Gets the value of macId
         *
         * @return the value of macId
         */
        public String getMacId() {
            return MacId;
        }

        /**
         * Gets the value of tagReadDataMessage.
         *
         * @return the value of tagReadDataMessage
         */
        public TagReadDataMessage getTagReadDataMessage() {
            return tagReadDataMessage;
        }

        /**
         * Sets the value of macId.
         *
         * @param macId the new value of macId
         * @return the StarFlexDataBuilder
         */
        public StarFlexDataBuilder setMacId(final String macId) {
            MacId = macId;
            return this;
        }

        /**
         * Sets the value of tagReadDataMessage.
         *
         * @param tagReadDataMessage the new value of tagReadDataMessage
         * @return the StarFlexDataBuilder
         */
        public StarFlexDataBuilder setTagReadDataMessage(final TagReadDataMessage tagReadDataMessage) {
            this.tagReadDataMessage = tagReadDataMessage;
            return this;
        }

        /**
         * Sets all values with default values.
         *
         * @return the StarFlexDataBuilder
         */
        private StarFlexDataBuilder setDefaultValues() {
            this.tagReadDataMessage = new TagReadDataMessage.TagReadDataMessageBuilder().setDefaultValues().build();
            return this;
        }

        /**
         * Sets all value with ramdom values.
         *
         * @return the StarFlexDataBuilder
         */
        public StarFlexDataBuilder setRandomValues() {
            return this.setDefaultValues();
        }

        /**
         * Builds a StarFlexData
         *
         * @return the StarFlexData
         */
        public StarFlexData build() {
            return new StarFlexData(this);
        }
    }
}
