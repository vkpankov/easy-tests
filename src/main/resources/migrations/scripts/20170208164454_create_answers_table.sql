--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // create_answers_table
CREATE TABLE public.answers
(
    answer_id serial NOT NULL,
    answer_text text,
    answer_qid integer NOT NULL,
    PRIMARY KEY (answer_id),
    FOREIGN KEY (answer_qid)
        REFERENCES public.questions (question_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)
-- //@UNDO
DROP TABLE public.answers;